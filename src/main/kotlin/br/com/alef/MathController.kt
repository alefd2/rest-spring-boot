package br.com.alef

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

//TODO: numberTwo e numberOne são os nome que serão requisitados no path
@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberOne") numberTwo: String?
    ): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw Exception()
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    private fun convertToDouble(strNumber: String?): Double {
        if(strNumber.isNullOrBlank()) return 0.0

        //convert  R$ 10,20 and USS10.20
        val number = strNumber.replace(",".toRegex(), ".")
        return if(isNumeric(number)) number.toDouble() else 0.0
    }


    private fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false;
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches( """[+-]?[0-9]*\.?[0-9]+""".toRegex())
    }

}