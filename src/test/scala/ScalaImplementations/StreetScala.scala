package ScalaImplementations

object StreetScala {
    val s0 = 0
    val s1 = 1
    val s2 = 2
    val s3 = 3
    val s4 = 4
    val s5 = 5

    val green = 0
    val yellow = 1
    val red = 2
    //TODO: add returns for stoplight color and edit test cases
    def nextState(state: Int, flagsSeen: Int): (Int, Int, Int) = {
        var nextState: Int = s0
        var MainState: Int = green
        var SideState: Int = red

        if (state == s0) {
            if (flagsSeen == 10){
                MainState = yellow
                SideState = red
                nextState = s1
            }
        }
        else if (state == s1) {
            if (flagsSeen == 4){
                MainState = red
                SideState = red
                nextState = s2
            }
        }
        else if (state == s2) {
            if (flagsSeen == 1){
                MainState = red
                SideState = green
                nextState = s3
            }
        }
        else if (state == s3) {
            if (flagsSeen == 10){
                MainState = red
                SideState = yellow
                nextState = s4
            }
        }
        else if (state == s4) {
            if (flagsSeen == 4){
                MainState = red
                SideState = red
                nextState = s5
            } 
        }
        else if (state == s5) {
            if (flagsSeen == 1){
                MainState = green
                SideState = red
                nextState = s0
            }
        }

        (nextState, MainState, SideState)
    }
}