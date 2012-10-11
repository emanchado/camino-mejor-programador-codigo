(defun percentage (percent amount)
  (* amount (/ percent 100)))

(defun calculate-price (cost nitems limit percent-tax)
  (let* ((total-price (* cost nitems))
         (tax         (percentage percent-tax total-price)))
    (if (> total-price limit)
      (+ total-price tax)
      total-price)))
