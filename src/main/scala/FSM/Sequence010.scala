package FSM

import chisel3._
import chisel3.util._

//Sequcence 010
//FSM to detect the sequence of bits: 010.
//The current bit comes in on io.nextBit and changes every rising edge
//The module should output 1 to io.status when the sequence is seen, and 0 otherwise 

//io.state is an output of the current state

class Sequence010 extends Module{
    val io = IO(new Bundle {
        val nextBit  = Input(UInt(1.W))

        val status = Output(Bool()) 
        val state = Output(UInt(2.W))
    })



    
}


