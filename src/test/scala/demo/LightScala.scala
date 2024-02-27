package demo

//A Scala object implementation of the FSM to control the light
//Used for testing comparison purposes
object LightScala {
    val Off = 0
    val Dim = 1
    val Medium = 2
    val Bright = 3

    def nextState(state: Int, click: Boolean): Int = {
        //start off
        var nextState: Int = Off

        //each state check for a click
        if (state == Off) {
            if (click) nextState = Dim
        } 
        else if (state == Dim) {
            if (click) nextState = Medium
        } 
        else if (state == Medium) {
            if (click) nextState = Bright
        } 
        else if (state == Bright) {
            if (click) nextState = Off
        }

        //return state
        nextState
    }
}