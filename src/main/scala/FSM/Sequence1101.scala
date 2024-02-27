package FSM

import chisel3._
import chisel3.util._

//Sequcence 1101
//FSM to detect the sequence of bits: 1101
//The current bit comes in on io.nextBit and changes every rising edge
//The module should output 1 to io.status when the sequence is seen, and 0 otherwise 

//io.state is an output of the current state
//Think about overlap, and what state you should go to if you fail partially through
//the sequence.... 
//Take a look at the tests for more hints
class Sequence1101 extends Module{
    val io = IO(new Bundle {
        val nextBit  = Input(UInt(1.W))

        val status = Output(Bool()) 
        val state = Output(UInt(2.W))
    })




    
}


