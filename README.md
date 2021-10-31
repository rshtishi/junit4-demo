# junit-4-demo

### Simple Test

- SUT(System Under Test)

```aidl
    public Money(int amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("illegal amount: [" + amount + "]");
        }
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("illegal currency: [" + currency + "]");
        }
        this.amount = amount;
        this.currency = currency;
    }
```

- Client

```aidl
    @Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "USD");
        assertEquals(10, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }
```

### Testing Exceptions

```aidl
    @Test
    public void constructorShouldThrowIllegalAmountArgumentException() {
        try {
            Money money = new Money(-1, "");
        } catch (IllegalArgumentException exception) {
            String expectedExceptionMessage = "illegal amount: [-1]";
            assertEquals(expectedExceptionMessage, exception.getMessage());
        }
    }
```

### Parametrized Test

- Reading input from method

```aidl
@RunWith(JUnitParamsRunner.class)
public class MoneyParameterizedTest {

    public static final Object[] getTestData() {
        return new Object[]{
                new Object[]{10, "EUR"},
                new Object[]{20, "USD"},
                new Object[]{30, "ALL"}
        };
    }

    @Test
    @Parameters(method = "getTestData")
    public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
        Money money = new Money(amount,currency);
        assertEquals(amount,money.getAmount());
        assertEquals(currency,money.getCurrency());
    }

}
```

- Reading input from CSV file

```aidl
@RunWith(JUnitParamsRunner.class)
public class ReadCSVJUnitParamsTes {

    @Test
    @FileParameters(value = "classpath:test-data.csv", mapper = CsvWithHeaderMapper.class)
    public void shouldCalculateDiscount(double value, double expectedResult) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        double result = discountCalculator.calculate(value);
        assertEquals(expectedResult,result,0);
    }
}
```

- Reading input from Excel file

```aidl
@RunWith(DataDrivenTestRunner.class)
public class ReadExcelTest {

    @Test
    @DataLoader(filePaths = {"test-data.xls"}, loaderType = LoaderType.EXCEL)
    public void shouldCalculateDiscount(@Param(name = "value") Double value, @Param(name = "result") Double expectedResult) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        double result = discountCalculator.calculate(value);
        assertEquals(expectedResult, result, 0);
    }
}
```

### Using the Rule to implement test case for non-functional requirements

```aidl
public class TimeoutTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(20);

    @Ignore
    @Test
    public void willFail() throws InterruptedException {
        Thread.sleep(100);
    }
    @Test
    public void willPass() throws InterruptedException {
        Thread.sleep(10);
    }
}
```

### Test Doubles(Mocks, Stubs, Test Spies)

- SUT 

```aidl
public class MailService {

    private DeliveryPlatform platform;

    public MailService(DeliveryPlatform platform) {
        this.platform = platform;
    }

    public void send(String to, String subject, String body, boolean html) {
        Format format = Format.TEXT_ONLY;
        if (html) {
            format = Format.HTML;
        }
        Email email = new Email(to, subject, body);
        email.setFormat(format);
        platform.deliver(email);
    }

}
```

- Client

```aidl
@RunWith(MockitoJUnitRunner.class)
public class MailServiceTest {

    @Mock
    DeliveryPlatform platform;

    @InjectMocks
    MailService emailService;

    @Captor
    ArgumentCaptor<Email> emailCaptor;

    @Test
    public void testSendMailSuccessfully(){
        emailService.send("x@email.com","Hi","Wish you the best",false);
        verify(platform).deliver(emailCaptor.capture());
        Email emailCaptorValue = emailCaptor.getValue();
        assertEquals("x@email.com",emailCaptorValue.getTo());
        assertEquals("Hi", emailCaptorValue.getSubject());
        assertEquals("Wish you the best", emailCaptorValue.getBody());
    }

}
```

### Special Cases

#### New Operator

- SUT

```aidl
    public BankAccount openBankAccount(double amount, String currency) {
        Validator validator = new Validator();
        if (validator.validate(amount) && validator.validate(currency)) {
            BankAccount bankAccount = new BankAccount(amount, currency);
            return bankAccount;
        }
        throw new IllegalArgumentException("Illegal Input passed to openBankAccount method");
    }
```

- Client

```aidl
    @Test
    public void shouldOpenBankAccountSuccessfully() throws Exception {
        BankClient bankClient = new BankClient();
        Validator validator = mock(Validator.class);
        when(validator.validate(anyDouble())).thenReturn(true);
        when(validator.validate(anyString())).thenReturn(true);
        whenNew(Validator.class).withNoArguments().thenReturn(validator);
        BankAccount bankAccount = bankClient.openBankAccount(5, "USD");
        verifyNew(Validator.class).withNoArguments();
        assertNotNull(bankAccount);
    }
```
#### Private Method

- SUT

```aidl
public class AverageCalculator {

    public double compute(int num1,int num2) {
        int sum = calculateSum(num1, num2);
        return sum / 2;
    }

    private int calculateSum(int num1,int num2) {
        return num1+num2;
    }
}
```

- Client

```aidl
@RunWith(PowerMockRunner.class)
@PrepareForTest(AverageCalculator.class)
public class AverageCalculatorTest {

    @Test
    public void calculateTheAverageSuccessfully() throws Exception {
        AverageCalculator averageCalculator = spy(new AverageCalculator());
        when(averageCalculator, method(AverageCalculator.class, "calculateSum", int.class, int.class))
                .withArguments(5,5).thenReturn(10);
        double result = averageCalculator.compute(5,5);
        assertEquals(5.0,result,0);

    }

}
```

#### Static Method

- SUT

```aidl
public class SMS {

    public String format(String message) {
        String formattedMessage = Utils.format(message);
        return formattedMessage;
    }
}
```

- Client

```aidl
@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class SMSTest {

    public static final String MSG = "Are you ok?";

    @Test
    public void testFormatSMS(){
        SMS sms = new SMS();
        mockStatic(Utils.class);
        when(Utils.format(MSG)).thenReturn(MSG.toUpperCase());
        String result = sms.format(MSG);
        assertEquals(MSG.toUpperCase(),result);
    }

}
```