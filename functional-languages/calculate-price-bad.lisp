(defun calculate-price-BAD (cost nitems limit percent-tax)
  (setq total-price (* cost nitems))
  (if (> total-price limit)
      (progn
        (setq tax (* total-price (/ percent-tax 100)))
        (setq total-price (+ total-price tax))))
  total-price)

(print (calculate-price 50 4 250 15))
(print (calculate-price 50 4 100 15))
(print (calculate-price 50 4 200 30))
(print (calculate-price 50 4 199 30))
