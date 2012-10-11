def best_time(list):
  if len(list) == 0:
    return None
  return sorted(list)[0]

times = [5, 9, 4, 6, 10, 8]
best_time(times)
print times
