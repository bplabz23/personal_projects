#lang racket





; *******************************************************************************
;   Name:             eat-word
;
;   Parameters:
;               1) word         -     list 
;               2) start state  -     function
;
;   Return:     state
;
;   Description:
;                   Processes an entire word and returns the halting state.
;   
;   Notes:    This is the main algorithm a DFA follows when it processes a word.
;               Uses recursion.
; ******************************************************************************* 

(define eat-word
  (lambda (word state)
      (if (null? word)                                                                  ; IF the word is empty
        state                                                                           ; THEN return the current state the DFA is in
        (eat-word (cdr word) (transition-function state (car word))))))                 ; OTHERWISE shorten the word, change to next state, and repeat on updated values (recursion) 
  
    
  
  
 

; *******************************************************************************
;   Name:             transition-function
;
;   Parameters:
;                   1) state   -  function 
;                   2) letter  -  char from list
;
;   Return:         state
;
;   Description:
;                   Accepts a state and a letter; returns the next state.
;
;   Notes:
;                   This is a helper function of eat-word. It does not actually
;           know the transition table of a DFA, but it dynamically calls the current
;           state passed to it             
;
; ******************************************************************************* 

(define (transition-function state letter)       ; transition-function(state, letter)
  (state letter)                                 ; States are also functions
  )






; Each state is a container that holds its own transitions.



; state q-zero function  -> returns new state
(define (q-zero letter)
  (if (=  letter 0) q-zero q-one)
  )



; state q-one function  -> returns new state
(define (q-one letter)
  (if (= letter 0) q-one q-zero)
  )




; -------------- MAIN PROGRAM -----------------
(define word '(1 1 1 0))
(eat-word word q-zero)