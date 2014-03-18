package org.modelcatalogue.forms

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SampleFormService)
@Mock([FormDesign, FormDesignElement, QuestionElement, InputField, TextField, SectionElement, TextElement, Rule])
class SampleFormServiceSpec extends Specification {

    def "create some sample forms"(){

        when:
        service.createForm()

        then:
        true

    }

}
