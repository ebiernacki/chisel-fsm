package ScalaImplementations

//Scala Implementation of Sequence Detector
object Sequence1101Scala {
    val s0 = 0
    val s1 = 1
    val s2 = 2
    val s3 = 3

    def nextState(state: Int, nextBit: Int): Int = {
        
        var nextState = s0

        if (state == s0) {
            if (nextBit == 1) nextState = s1
            else nextState = s0
        } 
        else if (state == s1) {
            if (nextBit == 1) nextState = s2
            else nextState = s0
        } 
        else if (state == s2) {
            if (nextBit == 0) nextState = s3
            else if (nextBit == 1) nextState = s2
        } 
        else if (state == s3) {
            if (nextBit == 1) nextState = s1
            else if (nextBit == 0) nextState = s0
        }

        nextState
        
    }

    def seqFound(state: Int, nextBit: Int): Int = {

        var seqFound = 0

        if((state == s3) && (nextBit == 1)) seqFound = 1
        else seqFound = 0

        seqFound
    }
}
