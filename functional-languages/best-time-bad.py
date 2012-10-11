def best_time_BAD(list):
  if len(list) == 0:
    return None
  list.sort()
  return list[0]

times = [5, 9, 4, 6, 10, 8]
best_time_BAD(times)
print times
