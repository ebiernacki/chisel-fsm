package FSM
import ScalaImplementations._
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random

class StreetTest extends AnyFlatSpec with ChiselScalatestTester {
    "StreetTest Test" should s"work" in {
        test(new Street).withAnnotations(Seq(WriteVcdAnnotation)){ dut => 
            val stateStrings = Map(
                0 -> "green",
                1 -> "yellow",
                2 -> "red",
            )

            val sStrings = Map(
                0 -> "s0",
                1 -> "s1",
                2 -> "s2",
                3 -> "s3",
                4 -> "s4",
                5 -> "s5",
            )
            
            dut.clock.step(8*10)
            println("Current State: " + sStrings(dut.io.state.peekInt().intValue))
            println("Main Active: " + stateStrings(dut.io.MainActive.peekInt().intValue))
            println("Side Active: " + stateStrings(dut.io.SideActive.peekInt().intValue))

            var (scalaState, newMain, newSide) = StreetScala.nextState(5, 1)
            println("Scala state: " + sStrings(scalaState))
            println("Scala Main: " + stateStrings(newMain))
            println("Scala Side: " + stateStrings(newSide))

            dut.io.MainActive.expect(newMain.U)
            dut.io.SideActive.expect(newSide.U)
            dut.io.state.expect(scalaState.U)
            
            println("---------------------")
            
            // var (s1, s, s3) = StreetScala.nextState(scalaState, 10)

            dut.clock.step(8*4)
            var (scalaState1, newMain1, newSide1) = StreetScala.nextState(0, 10)
            println("Current State: " + sStrings(dut.io.state.peekInt().intValue))
            println("Main Active: " + stateStrings(dut.io.MainActive.peekInt().intValue))
            println("Side Active: " + stateStrings(dut.io.SideActive.peekInt().intValue))

            println("Scala state: " + sStrings(scalaState1))
            println("Scala Main: " + stateStrings(newMain1))
            println("Scala Side: " + stateStrings(newSide1))

            dut.io.MainActive.expect(newMain1.U)
            dut.io.SideActive.expect(newSide1.U)
            dut.io.state.expect(scalaState1.U)
            println("---------------------")


            dut.clock.step(8*1)
            var (scalaState2, newMain2, newSide2) = StreetScala.nextState(1, 4)
            println("Current State: " + sStrings(dut.io.state.peekInt().intValue))
            println("Main Active: " + stateStrings(dut.io.MainActive.peekInt().intValue))
            println("Side Active: " + stateStrings(dut.io.SideActive.peekInt().intValue))

            println("Scala state: " + sStrings(scalaState2))
            println("Scala Main: " + stateStrings(newMain2))
            println("Scala Side: " + stateStrings(newSide2))

            dut.io.MainActive.expect(newMain2.U)
            dut.io.SideActive.expect(newSide2.U)
            dut.io.state.expect(scalaState2.U)
            println("---------------------")


            dut.clock.step(8*10)
            var (scalaState3, newMain3, newSide3) = StreetScala.nextState(2, 1)
            println("Current State: " + sStrings(dut.io.state.peekInt().intValue))
            println("Main Active: " + stateStrings(dut.io.MainActive.peekInt().intValue))
            println("Side Active: " + stateStrings(dut.io.SideActive.peekInt().intValue))

            println("Scala state: " + sStrings(scalaState3))
            println("Scala Main: " + stateStrings(newMain3))
            println("Scala Side: " + stateStrings(newSide3))

            dut.io.MainActive.expect(newMain3.U)
            dut.io.SideActive.expect(newSide3.U)
            dut.io.state.expect(scalaState3.U)
            println("---------------------")

            dut.clock.step(8*4)
            var (scalaState4, newMain4, newSide4) = StreetScala.nextState(3, 10)
            println("Current State: " + sStrings(dut.io.state.peekInt().intValue))
            println("Main Active: " + stateStrings(dut.io.MainActive.peekInt().intValue))
            println("Side Active: " + stateStrings(dut.io.SideActive.peekInt().intValue))

            println("Scala state: " + sStrings(scalaState4))
            println("Scala Main: " + stateStrings(newMain4))
            println("Scala Side: " + stateStrings(newSide4))

            dut.io.MainActive.expect(newMain4.U)
            dut.io.SideActive.expect(newSide4.U)
            dut.io.state.expect(scalaState4.U)
            println("---------------------")
            
            dut.clock.step(8*1)
            var (scalaState5, newMain5, newSide5) = StreetScala.nextState(4, 4)
            println("Current State: " + sStrings(dut.io.state.peekInt().intValue))
            println("Main Active: " + stateStrings(dut.io.MainActive.peekInt().intValue))
            println("Side Active: " + stateStrings(dut.io.SideActive.peekInt().intValue))

            println("Scala state: " + sStrings(scalaState5))
            println("Scala Main: " + stateStrings(newMain5))
            println("Scala Side: " + stateStrings(newSide5))

            dut.io.MainActive.expect(newMain5.U)
            dut.io.SideActive.expect(newSide5.U)
            dut.io.state.expect(scalaState5.U)
            println("---------------------")

            dut.clock.step(8*10)
            var (scalaState6, newMain6, newSide6) = StreetScala.nextState(5, 1)
            println("Current State: " + sStrings(dut.io.state.peekInt().intValue))
            println("Main Active: " + stateStrings(dut.io.MainActive.peekInt().intValue))
            println("Side Active: " + stateStrings(dut.io.SideActive.peekInt().intValue))

            println("Scala state: " + sStrings(scalaState6))
            println("Scala Main: " + stateStrings(newMain6))
            println("Scala Side: " + stateStrings(newSide6))

            dut.io.MainActive.expect(newMain6.U)
            dut.io.SideActive.expect(newSide6.U)
            dut.io.state.expect(scalaState6.U)
            println("---------------------")

            dut.clock.step(8*4)
            var (scalaState7, newMain7, newSide7) = StreetScala.nextState(0, 10)
            println("Current State: " + sStrings(dut.io.state.peekInt().intValue))
            println("Main Active: " + stateStrings(dut.io.MainActive.peekInt().intValue))
            println("Side Active: " + stateStrings(dut.io.SideActive.peekInt().intValue))

            println("Scala state: " + sStrings(scalaState7))
            println("Scala Main: " + stateStrings(newMain7))
            println("Scala Side: " + stateStrings(newSide7))
            
            dut.io.MainActive.expect(newMain7.U)
            dut.io.SideActive.expect(newSide7.U)
            dut.io.state.expect(scalaState7.U)
            println("---------------------")
                       
        }
    }
}