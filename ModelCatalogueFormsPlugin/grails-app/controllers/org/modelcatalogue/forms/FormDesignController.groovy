package org.modelcatalogue.forms

import grails.converters.XML
import grails.rest.RestfulController


class FormDesignController extends RestfulController<FormDesign> {


    FormDesignController() {
        super(FormDesign)
    }

    @Override

    def show() {
        XML.use('deep')
        respond queryForResource(params.id)
    }

}
