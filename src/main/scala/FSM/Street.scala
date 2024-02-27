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
    



    
}