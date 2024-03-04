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
class Sequence1101 extends Module{ //1101101
    val io = IO(new Bundle {
        val nextBit  = Input(UInt(1.W))

        val status = Output(Bool()) 
        val state = Output(UInt(2.W))
    })

    val s0 :: s1 :: s2 :: s3 :: Nil = Enum(4)

    val stateReg = RegInit(s0)

    switch(stateReg){
        is(s0){
            stateReg := Mux(io.nextBit === 1.U, s1, s0)
            // when(io.nextBit === 1.U){
            //     stateReg := s1
            // }
            
        }
        is(s1){          
            stateReg := Mux(io.nextBit === 1.U, s2, s1)
            // when(io.nextBit === 1.U){
            //     stateReg := s2
            // }.elsewhen(io.nextBit === 0.U){
            //     stateReg := s1
            // }
            
        }
        is(s2){
            stateReg := Mux(io.nextBit === 1.U, s2, s3)
            // when(io.nextBit === 0.U){
            //     stateReg := s3
            // }
            // .elsewhen(io.nextBit === 1.U){
            //     stateReg := s2
            // }
        }
        is(s3){
            //seen 110
            when(io.nextBit === 1.U){
                stateReg := s1
            }
            .elsewhen(io.nextBit === 0.U){
                stateReg := s0
            }
        }
    }

    io.status := Mux((io.nextBit === 1.U) && (stateReg === s3), true.B, false.B)
    io.state := stateReg    
}


