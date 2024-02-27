package FSM
import ScalaImplementations._

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random


class Sequence010Test extends AnyFlatSpec with ChiselScalatestTester {
    "SequenceDetectorTest Test" should s"work" in {
        test(new Sequence010) { dut =>

            val stateStrings = Map(
                0 -> "s0",
                1 -> "s1",
                2 -> "s2",
                3 -> "s3"
            )
        
            var scalaState = 0

            val inputValues: Seq[Int] = Seq(
                1, 1, 0, 1, 0,   
                1, 1, 0, 1, 1,     
                1, 0, 1, 0, 0,  
                0, 1, 0, 1, 0,   
                1, 0, 1, 0, 1,   
                0, 1, 0, 1, 1,   
                1, 1, 0, 1, 1,   
                1, 1, 0, 0, 0,  
                1, 0, 1, 1, 0,  
                1, 1, 0, 0, 1   
            )

            println("Scala Function Gives: " + stateStrings(scalaState))
            println("Chisel Module Gives : " + stateStrings(dut.io.status.peekInt().intValue))
            println("----------------------------")

            for (i <- inputValues) {
                println("next bit: " + i)
                //next state for chisel module
                dut.io.nextBit.poke(i.U)
                dut.clock.step(1)
                

                //next state for scala function
                scalaState = Sequence010Scala.nextState(scalaState, i)

                println("Scala Function Gives: " + stateStrings(scalaState))
                println("Chisel Module Gives : " + stateStrings(dut.io.state.peekInt().intValue))

                println("Sequence Found?: " + dut.io.status.peek())
                println("----------------------------")
                                                 
                // Compare Chisel module output with Scala function output
                dut.io.status.expect(ScalaImplementations.Sequence010Scala.seqFound(scalaState).U)

            }
        }
    }
    // "SequenceDetectorTest Test" should s"work" in {
    //     test(new SequenceDetector).withAnnotations(Seq(WriteVcdAnnotation)){ dut => 

    //         val inputValues = Seq(1.U, 1.U, 0.U, 1.U, 0.U, 1.U, 1.U)

    //         for(i <- inputValues){
    //             dut.io.nextBit.poke(i)
    //             dut.clock.step(1)

    //             println(dut.io.status.peek())
    //         }
            
    //     }
    // }
}