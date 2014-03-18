package org.modelcatalogue.forms

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import groovy.util.slurpersupport.GPathResult
import org.codehaus.groovy.grails.plugins.web.mimes.MimeTypesFactoryBean
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(FormDesignController)
@Mock([FormDesign, FormDesignElement, QuestionElement, InputField, TextField, SectionElement, TextElement, Rule])
class FormDesignControllerSpec extends Specification {

    @Shared
    def sampleFormService
    ResultRecorder recorder

    def setup() {

        sampleFormService = new SampleFormService()

        recorder = DefaultResultRecorder.create(
                "../ModelCatalogueFormsPlugin/target/xml-samples/forms/",
                "../ModelCatalogueFormsPlugin/test/js/modelcatalogue/forms",
                "FormDesign"
        )
        sampleFormService.createForm()
        setupMimeTypes()

    }

    protected void setupMimeTypes() {
        def ga = grailsApplication
        ga.config.grails.mime.types =
                [html: ['text/html', 'application/xhtml+xml'],
                        xml: ['text/xml', 'application/xml'],
                        text: 'text/plain',
                        js: 'text/javascript',
                        rss: 'application/rss+xml',
                        atom: 'application/atom+xml',
                        css: 'text/css',
                        csv: 'text/csv',
                        all: '*/*',
                        json: ['application/json', 'text/json'],
                        form: 'application/x-www-form-urlencoded',
                        multipartForm: 'multipart/form-data'
                ]

        defineBeans {
            mimeTypes(MimeTypesFactoryBean) {
                grailsApplication = ga
            }
        }
    }


    def "Show single existing item as XML"() {
        response.format = "xml"
        params.id = FormDesign.findByName("Lymphoma MDT Proforma").id
        controller.show()
        GPathResult xml = response.xml
        recorder.recordResult "showOne", xml

        expect:
        xml


    }
}
