package net.enkime.demo

class MyBean {
	val myVal = "read_only"
	var myVar = "read_write"
	def myDef = "read_from_method"	
}

class My(val myVal:String = "read_only",var myVar:String = "read_write", var fun: () => Any ) {
	
}

