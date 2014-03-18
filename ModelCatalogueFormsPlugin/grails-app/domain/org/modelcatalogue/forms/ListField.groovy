package org.modelcatalogue.forms

class ListField extends InputField{

	Boolean multiSelect
	Boolean ordered
	Boolean fillIn
	
	static hasMany = [listItems: ListItem]
	
    static constraints = {
    }
}
