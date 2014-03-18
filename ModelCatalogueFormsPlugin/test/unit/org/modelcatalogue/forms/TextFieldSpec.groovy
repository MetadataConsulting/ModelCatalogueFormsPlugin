package org.modelcatalogue.forms

import grails.test.mixin.Mock
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by adammilward on 03/02/2014.
 */
@Mock (TextField)
class TextFieldSpec extends Specification{

    @Unroll
    def "create a new text field from #args validates to #validates" (){

        expect:
        TextField.list().isEmpty()

        when:
        TextField field = new TextField(args)
        field.save()

        then:

        field.hasErrors() == validates
        TextField.list().size() == size

        where:
        validates | args             | size
        false     | [:]              | 0
        false     | [name: "x" *256] | 0
        true      | [name: "String", minValue: 0, maxValue: 255, placeholder:  "answer the question here", maxCharacters: 255, unitOfMeasure: "mph"] | 1
    }




//    @Unroll
//    def "create a new data type from #args validates to #validates" (){
//
//        expect:
//
//        DataType.list().isEmpty()
//
//        when:
//
//        DataType type = new DataType(args)
//        type.save()
//
//
//        then:
//
//        !type.hasErrors() == validates
//        DataType.list().size() == size
//
//        where:
//        validates | args             | size
//        false     | [:]              | 0
//        false     | [name: "x" *256] | 0
//        true      | [name: "String"] | 1
//
//    }



}
