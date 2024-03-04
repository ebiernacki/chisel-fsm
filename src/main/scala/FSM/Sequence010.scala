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

    val s0 :: s1 :: s2 :: s3 :: Nil = Enum(4)


    val stateReg = RegInit(s0)
    
    switch(stateReg){
        is(s0){
            when(io.nextBit === 0.U){
                stateReg := s1
            }
        }
        is(s1){
            when(io.nextBit === 1.U){
                stateReg := s2
            }
        }
        is(s2){
            when(io.nextBit === 0.U){
                stateReg := s3
            }.elsewhen(io.nextBit === 1.U){
                stateReg := s0
            }
        }
        is(s3){
            when(io.nextBit === 0.U){
                stateReg := s1
            }
            .elsewhen(io.nextBit === 1.U){
                stateReg := s2
            }
        }
    }

    io.status := Mux(stateReg === s3, true.B, false.B)
    io.state := stateReg
    
}


