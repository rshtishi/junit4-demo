package com.github.rshtishi.doc;

import com.github.rshtishi.doc.Client;
import com.github.rshtishi.doc.Template;

public interface TemplateEngine {

    public String prepareMessage(Client client, Template template);
}
