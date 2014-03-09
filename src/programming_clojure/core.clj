(ns programming-clojure.core)

;;; Chapter 3. Unifying Data with Sequences

;; 3.1
; First element
(first '(1 2 3))

; Every elements except first
(rest '(1 2 3))

; Puts to the first
(cons 1 '(2 3))

; Seq on any seq-able coll
(seq '(1 2 3))
'()       ;=> ()
(seq '()) ;=> nil

; seq of items after the first
(next '(1 2 3))
