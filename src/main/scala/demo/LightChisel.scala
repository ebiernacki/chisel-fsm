package demo

import chisel3._
import chisel3.util._

//Simple FSM to show the state of a light that changes brightness with every click
class Light extends Module{
    val io = IO(new Bundle {
        val click  = Input(Bool())

        val status = Output(UInt(2.W))
    })

    val off :: dim :: medium :: bright :: Nil = Enum(4)

    val stateReg = RegInit(off)

    switch(stateReg){
        is(off){
            when(io.click){
                stateReg := dim
            }
        }
        is(dim){
            when(io.click){
                stateReg := medium
            }
        }
        is(medium){
            when(io.click){
                stateReg := bright
            }
        }
        is(bright){
            when(io.click){
                stateReg := off
            }
        }
    }

    io.status := stateReg
}