require 'pp'

def best_time_BAD(list)
  if list.empty?
    nil
  else
    list.sort!
    list[0]
  end
end

times = [5, 9, 4, 6, 10, 8]
best_time_BAD(times)
pp times

def best_time(list)
  if list.empty?
    nil
  else
    list.sort[0]
  end
end

times2 = [5, 9, 4, 6, 10, 8]
best_time(times2)
pp times2
