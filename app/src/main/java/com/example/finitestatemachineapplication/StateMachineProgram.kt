package com.example.finitestatemachineapplication


// Define the possible states
enum class State { NULL, A, B, C, D, E }

// Create a class to represent the Finite State Machine
class StateMachine {
    private var currentState = State.NULL

    // Define the valid state transitions
    private val validTransitions = mapOf(
        State.NULL to listOf(State.A),
        State.A to listOf(State.A, State.B, State.C),
        State.B to listOf(State.C),
        State.C to listOf(State.D),
        State.D to listOf(State.E),
        State.E to listOf(State.E)
    )

    // Function to handle state transitions and validation
    fun transition(newState: State) {
        val validNextStates = validTransitions[currentState]
        if (validNextStates != null && validNextStates.contains(newState)) {
            println("OK - Transition from $currentState to $newState")
            currentState = newState
        } else {
            println("Error - Invalid transition from $currentState to $newState")
            currentState = State.NULL
        }
    }
}

fun main() {
    val stateMachine = StateMachine()

    //  A series of random state transitions
    val events =
        listOf(State.A, State.B, State.C, State.D, State.E, State.E, State.A)

    val events1 =
        listOf(State.A, State.C,State.A, State.D, State.E, State.E)


    for (event in events) {
        stateMachine.transition(event)
    }
}
