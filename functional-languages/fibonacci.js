var fibonacciCache = {0: 1, 1: 1};

function fibonacci(pos) {
  if (pos < 0) {
    throw "The Fibonacci series is defined only for natural numbers";
  }

  if (! fibonacciCache.hasOwnProperty(pos)) {
    console.log("Calculating result for position " + pos);
    fibonacciCache[pos] = fibonacci(pos - 1) + fibonacci(pos - 2);
  }

  return fibonacciCache[pos];
}


console.log("Fibonacci 5 -> " + fibonacci(5));
console.log("Fibonacci 3 -> " + fibonacci(3));
console.log("Fibonacci 10 -> " + fibonacci(10));


exports.fibonacci = fibonacci;
