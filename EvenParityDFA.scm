#lang racket




; eat word -> return final state
(define eat-word
  (lambda (word state)
    (if (null? word)
        state
        (eat-word (cdr word) (transition-function state (car word))))))
  
    
  
  
 



; transition function
(define (transition-function state letter)       ; transition-function(state, letter)
  (state letter)                                 ; States are also functions
  )


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