# Chisel Finite State Machine Repository

This assignment has 3 modules for you to complete.

- Sequence010
    - Build a FSM to detect the sequence of bits: 010. The current bit comes in on io.nextBit and change every rising edge. The module should output 1 to io.status when the sequence is seen, and 0 otherwise, along with the current state on io.state
    - It might help to draw the FSM before you code it. Make sure to account for overlaps 

- Sequence1101
    - Same as Sequence010, but with the sequence 1101

- Street
    - This module models a perpendicular street intersection (with no turns). There is a main street light and side street light, that must follow the FSM in the picutre below with the states and lights for each street. The output should be the the active color of each light (use Enums), and the current state of the overall FSM

    - <img src=".\StreetFSM.png" alt="Alt text" style="width: 80%; height: 80%;">

    - !!!! Notice !!!! the timing needed with each state? Luckily we have our AnyCounter Module can use it to count how many "seconds" have passed by, of course full seconds are not convient for testing, so when you create your AnyCounter module, do so with the parameters AnyCounter(8, 5) so that they work with the tests
    


There is also a demo package that has the light demo from class on how to use registers and FSM.

**Getting the Repo:**
```bash
$ https://github.com/ebiernacki/chisel-fsm.git 
```

**Testing the Examples**
- To test the Sequence010 Module:
    ```bash
    sbt
    testOnly FSM.Sequence010Test
    ```
- replace ```Sequence010Test``` with the name of the test you want to run



## External Setup Guides and Running the Projects

- [Java, Sbt and Chisel Guide](https://docs.google.com/document/d/13pX-4cFuGuj_i7VRhmksyf7YL6-qXiF8-O9J9m_yVfI/edit?usp=sharing)
- [GTKWave Guide](https://docs.google.com/document/d/1-muYy8XSGP4EbMIbLuwTEscIj1UC-u8HU5glcBpIFUo/edit?usp=sharing)
- [Vivado Guide](https://docs.google.com/document/d/1O-y1rnS1V_Bjyc2GwYd9C6Gq1IsqVcxacy2lTD6tHME/edit?usp=sharing)





