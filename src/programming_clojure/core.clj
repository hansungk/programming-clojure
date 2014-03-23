(ns programming-clojure.core)

;;; Chapter 3. Unifying Data with Sequences

;; 3.1
; First element
(first '(1 2 3))

; Every elements except first
(rest '(1 2 3))	;=> PersistentList
(rest [1 2 3])	;=> PersistentVector$ChunkedSeq

; Puts to the first
(cons 1 '(2 3))

; Seq on any seq-able coll
(seq '(1 2 3))
'()		;=> ()
(seq '())	;=> nil

; seq of items after the first
(next '(1 2 3))

; Sort set elements in Clojure's own way
(sorted-set :the :quick :brown :fox)
{:a 1 :b 2 :c 3}

; Sort map elements sorted by key
(sorted-map :c 3 :b 2 :a 1)

; Adds element(s) to collection
(conj '(1 2 3) :a)	; Lists: to the front
(conj [1 2 3] :a)	; Vectors: to the end

; Series of conj's
(into '(1 2 3) '(:a :b :c))
(into [1 2 3] [:a :b :c])

;; 3.2
; Make a sequence from a start to an end
(range 10)	;=> 0 to 9
(range 10 20)	;=> 10 to 19
(range 1 25 2)	;=> 1 to 25 incrementing by 2

; Repeat n times
(repeat 5 1)	;=> five ones
(repeat 10 "x")	;=> ten xs

; Infinite repeat, applying a function each time
(take 10 (iterate inc 1))
(defn whole-numbers [] (iterate inc 1))

; Cycle collection
(take 10 (cycle (range 3)))

; Interleaves collections
(interleave (whole-numbers) ["a" "b" "c" "d" "e"])	; those parens are needed

; Apply str is common enough
(clojure.string/join \, ["Apples" "Bananas" "Grapes"])

; For each collection type
(list 1 2 3)
(vector 1 2 3)
(hash-set 1 2 3)
(hash-map 1 2 3 4)

(vec (range 3))

;; Filtering Sequences
(take 10 (filter odd? (whole-numbers)))

(take-while (complement #{\a\e\i\o\u}) "the-quick-brown-fox")
(drop-while (complement #{\a\e\i\o\u}) "the-quick-brown-fox")

(split-at 5 (range 10))
(split-with #(<= % 10) (range 0 20 2))

(every? odd? [1 3 5]) ; every? is a predicate
(some even? [1 2 5])
; some is not a predicate
(some identity [nil false 1 nil 2])

(not-every? even? (whole-numbers))
(not-any? even? (whole-numbers))

;; Transforming sequences
(map #(format "<p>%s</p>" %) ["the" "quick" "brown" "fox"])
