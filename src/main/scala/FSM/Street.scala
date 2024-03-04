package FSM

import chisel3._
import chisel3.util._

//This module models a perpendicular street intersection (with no turns).
//There is a main street light and side street light, that must follow the FSM in 
//the picutre in the Readme with the states and lights for each street
//The output should be the the active color of each light (use Enums)
//and the current state of the overall FSM

class Street extends Module{
    val io = IO(new Bundle {
        val MainActive = Output(UInt(2.W))
        val SideActive = Output(UInt(2.W))
        val state      = Output(UInt(3.W))
    })

    //states according to diagram
    val s0 :: s1 :: s2 :: s3:: s4 :: s5 :: Nil = Enum(6)
    val stateReg = RegInit(s0)

    //keep track of green yellow red UInts
    val green :: yellow :: red :: Nil = Enum(3)

    //start off with main as green and side as red
    val MainState = RegInit(green)
    val SideState = RegInit(red)

    //counter module
    val counter = Module(new AnyCounter(8, 5))

    val flagsSeen = RegInit(0.U(6.W)) //Amount of time passed
    flagsSeen := Mux(counter.io.flag, flagsSeen + 1.U,  flagsSeen) //when theres a flag seen, increment
    // when(counter.flagVal){
    //     flagsSeen := flagsSeen + 1.U
    // }

    switch (stateReg) {
        is(s0) {
            //after 10 "seconds", change lights and state and reset current seconds passed
            when(flagsSeen === 10.U){
                MainState := yellow
                SideState := red
                flagsSeen := 0.U
                stateReg  := s1
            }
        }
        is(s1) {
            when(flagsSeen === 4.U){
                MainState := red
                SideState := red
                flagsSeen := 0.U
                stateReg  := s2
            }
        }
        is(s2) {
            when(flagsSeen === 1.U){
                MainState := red
                SideState := green
                flagsSeen := 0.U
                stateReg  := s3
            }
        }
        is(s3) {
            when(flagsSeen === 10.U){
                MainState := red
                SideState := yellow
                flagsSeen := 0.U
                stateReg  := s4
            }
        }
        is(s4) {
            when(flagsSeen === 4.U){
                MainState := red
                SideState := red
                flagsSeen := 0.U
                stateReg  := s5
            }
        }
        is(s5) {
            when(flagsSeen === 1.U){
                MainState := green
                SideState := red
                flagsSeen := 0.U
                stateReg  := s0
            }
        }
    }
    //hook up final IO
    io.MainActive := MainState
    io.SideActive := SideState
    io.state := stateReg
   
}