package com.example.calculator

import org.junit.Test

import org.junit.Assert.*
import java.util.Stack

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testBed2() {
        val result = bodmasCalc("10+(3-5*6/3)-456")

        println(result)

        assert(result == 3.5)
    }

    fun bodmasCalc(equation: String): Double {

        val tokens = equation.replace(" ", "").toCharArray()
        val values = mutableListOf<Double>()
        val operator = mutableListOf<Char>()
        val operation = mutableListOf<Double>()
        val bracket = mutableListOf<Char>()
        var i = 0
        var dec = ""
        while (i < tokens.size) {
            if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                operator.add(tokens[i])
                if (dec != "") {
                    try {
                        values.add(dec.toDouble())
                        dec = ""
                    } catch (e: Exception) {
                        println(e)
                        println("Enter a valid number")
                    }
                }
            } else if (tokens[i] == '(') {
                var j = i
                j++
                while (tokens[j] != ')') {
                    if (tokens[j] == '+' || tokens[j] == '-' || tokens[j] == '*' || tokens[j] == '/') {
                        bracket.add(tokens[j])
                        try {
                            operation.add(dec.toDouble())
                            dec = ""
                        } catch (e: Exception) {
                            println(e)
                            println("Enter a valid number")
                        }
                    } else dec += tokens[j]
                    j++
                }
                if (dec != "") {
                    try {
                        operation.add(dec.toDouble())
                        dec = ""
                    } catch (e: Exception) {
                        println(e)
                        println("Enter a valid number")
                    }
                }
                //println(operation)
                while (bracket.isNotEmpty())
                    compute(bracket, operation)
                values.add(operation.removeLast())
                i = j
            } else dec += tokens[i]
            i++
        }
        if (dec != "") {
            try {
                values.add(dec.toDouble())
            } catch (e: Exception) {
                println(e)
                println("Enter a valid number")
            }
        }

        while (operator.isNotEmpty())
            compute(operator, values)
        return values.last()
    }

    fun compute(operator: MutableList<Char>, values: MutableList<Double>) {
        var index: Int = -1
        var op = ' '
        var a: Double
        var b: Double
        if (operator.contains('/'))
            op = '/'
        else if (operator.contains('*'))
            op = '*'
        else if (operator.contains('+'))
            op = '+'
        else if (operator.contains('-'))
            op = '-'
        if (op != ' ') {
            index = operator.indexOf(op)
            a = values.removeAt(index)
            b = values.removeAt(index)
            values.add(index, operation(a, b, op))
            operator.removeAt(index)
        }
    }

    fun operation(a: Double, b: Double, op: Char): Double {
        if (op == '/') {
            try {
                return a / b
            } catch (e: Exception) {
                println(e)
                println("Division by zero not possible")
            }
        } else if (op == '*')
            return a * b
        else if (op == '+')
            return a + b
        else if (op == '-')
            return a - b
        return 0.0
    }
}