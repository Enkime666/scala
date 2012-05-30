package net.enkime.exception

object YourArgumentIsInvalidException {
	def createIAmYourFather(cause: Throwable = null) = new YourArgumentIsInvalidException("I am your father", cause)
	def createMyHairIsABird(cause: Throwable = null) = new YourArgumentIsInvalidException("My hair is a bird", cause)
}

class YourArgumentIsInvalidException(message: String = "", cause: Throwable = null)
		extends IllegalArgumentException(message, cause) {
}