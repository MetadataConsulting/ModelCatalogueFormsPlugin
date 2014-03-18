package org.modelcatalogue.forms

import grails.converters.XML
import groovy.util.slurpersupport.GPathResult

class SampleFormService {

    ResultRecorder recorder

    def setup(){

    }


    def createForm() {

        FormDesign formDesign = new FormDesign(name: "Lymphoma MDT Proforma", description:"a form for an mdt meeting", versionNo: "0.1").save()
        formDesign.header = new TextElement(name: "lymphoma_mdt_form_heading_1", label: "header", style: "cssClass", text: "GV Lymphoma MDT", formDesign: formDesign, designOrder: 1).save(failOnError: true)
        formDesign.footer = new TextElement(name: "lymphoma_mdt_form_footer_1", label: "footer", style: "cssClass", text: "footer for the form", formDesign: formDesign, designOrder: 1).save(failOnError: true)

 //formDesignElements

        SectionElement section1 = new SectionElement(title: "Heading-Patient-Identity-Details", style:"section1",  sectionNumber: "1", designOrder: 1, formDesign: formDesign).save(failOnError: true)
        SectionElement section2 = new SectionElement(title: "Data-Patient-Identity-Details", style:"section2", sectionNumber: "2", designOrder: 2, formDesign: formDesign).save(failOnError: true)
        SectionElement section3 = new SectionElement(title: "Heading-Demographics", style:"section3", sectionNumber: "3", designOrder: 3, formDesign: formDesign).save(failOnError: true)


        TextField n50 = new TextField(format: "an50", maxCharacters: 50).save(failOnError: true)
        TextField n10 = new TextField(format: "n10", maxValue: 10).save(failOnError: true)
        TextField an8 = new TextField(format: "an8", maxCharacters: 10).save(failOnError: true)
        TextField an10 = new TextField(format: "an10", maxCharacters: 10).save(failOnError: true)
        TextField an35 = new TextField(format: "an35", maxCharacters: 10).save(failOnError: true)
        TextField an135 = new TextField(format: "an135", maxCharacters: 10).save(failOnError: true)
        TextField date = new TextField(format: "an10 ccyy-mm-dd", maxCharacters: 10).save(failOnError: true)

        Rule rule1 = new Rule(
                name: 'display section rule',
                predicate: 'question4 < 7/3/1996',
                consequence: 'display'
        ).save(failOnError: true)



        QuestionElement question1 = new QuestionElement(label: "NHS Number:",  designOrder: 1, style:"question",
                questionNumber: "a", valueDomain: "154", dataElement:"127", inputField: n50, section: section1, formDesign: formDesign).save(failOnError: true)

        QuestionElement question2 = new QuestionElement(label: "Patient Identity Details",  designOrder: 1, style:"question",
                questionNumber: "a", valueDomain: "554", dataElement:"727", inputField: n10, section: section2, formDesign: formDesign).save(failOnError: true)

        QuestionElement question3 = new QuestionElement(label: "Local Identifier:",  designOrder: 2, style:"question",
                questionNumber: "b", valueDomain: "534", dataElement:"71", inputField: an10, section: section2, formDesign: formDesign).save(failOnError: true)

        QuestionElement question4 = new QuestionElement(label: "Birthday:",  designOrder: 3, style:"question",
                questionNumber: "c", valueDomain: "34", dataElement:"324", inputField: date, section: section2, formDesign: formDesign).save(failOnError: true)

        QuestionElement question5 = new QuestionElement(label: "Surname:",  designOrder: 1, style:"question",
                questionNumber: "a", valueDomain: "235", dataElement:"213", inputField: an35, section: section3, formDesign: formDesign).save(failOnError: true)

        QuestionElement question6 = new QuestionElement(label: "First Name:",  designOrder: 2, style:"question",
                questionNumber: "b", valueDomain: "23", dataElement:"4", inputField: an35, section: section3, formDesign: formDesign).save(failOnError: true)

        QuestionElement question7 = new QuestionElement(label: "Address:",  designOrder: 3, style:"question",
                questionNumber: "c", valueDomain: "576", dataElement:"99", inputField: an135, section: section3, formDesign: formDesign).save(failOnError: true)

        QuestionElement question8 = new QuestionElement(label: "Postcode:",  designOrder: 4, style:"question",
                questionNumber: "c", valueDomain: "576", dataElement:"99", inputField: an8, section: section3, formDesign: formDesign).save(failOnError: true)


        section3.addToRules(rule1)

    }
}
