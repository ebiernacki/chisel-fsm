package demo

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class LightTest extends AnyFlatSpec with ChiselScalatestTester {

    "Light Test" should "work" in {
        test(new Light) { dut =>

            val stateStrings = Map(
                0 -> "Off",
                1 -> "Dim",
                2 -> "Medium",
                3 -> "Bright"
            )
        
            var scalaState = 0

            //Compare to SW implementation
            println("Scala Function Gives: " + stateStrings(scalaState))
            println("Chisel Module Gives : " + stateStrings(dut.io.status.peekInt().intValue))
            println("----------------------------")

            for (_ <- 0 to 6) {
                
                //next state for chisel module
                dut.io.click.poke(true.B)
                dut.clock.step(1)
                dut.io.click.poke(false.B)
                dut.clock.step(1)

                //next state for scala function
                scalaState = LightScala.nextState(scalaState, true)

                println("Scala Function Gives: " + stateStrings(scalaState))
                println("Chisel Module Gives : " + stateStrings(dut.io.status.peekInt().intValue))
                println("----------------------------")
                                                 
                // Compare Chisel module output with Scala function output
                dut.io.status.expect(scalaState.U)
            }
        }
    }
}



///////OLDER WORKING TEST CODE
// "Light Test" should s"work" in {
//     test(new Light).withAnnotations(Seq(WriteVcdAnnotation)){ dut => 
//         val stateStrings = Map(
//             0 -> "off",
//             1 -> "dim",
//             2 -> "medium",
//             3 -> "bright"
//         )

//         for(_ <- 0 to 6){
//             println(stateStrings(dut.io.status.peekInt().intValue))
//             // println(dut.io.status.peekInt())
//             dut.io.click.poke(true.B)
//             println("Click!")
//             dut.clock.step(1)
//             dut.io.click.poke(false.B)
//             dut.clock.step(1)
//         }
//     }
// }


