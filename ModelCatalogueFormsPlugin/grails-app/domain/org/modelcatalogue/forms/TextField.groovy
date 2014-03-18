package org.modelcatalogue.forms

class TextField extends InputField{
	
	Integer minValue
    Integer maxValue

    static constraints = {
        minValue nullable:true
        maxValue nullable:true
    }
}
