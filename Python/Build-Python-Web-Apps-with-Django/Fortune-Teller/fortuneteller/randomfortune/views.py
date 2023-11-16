from django.shortcuts import render
import random

fortuneList = [
   "All will go well with your new project.",
   "If you continually give, you will continually have.",
   "Self-knowledge is a life long process.",
   "You are busy, but you are happy.",
   "Your abilities are unparalleled.",
   "Those who care will make the effort.",
   "Now is the time to try something new.",
   "Miles are covered one step at a time.",
   "Dont just think, act!"
]

# Create your views here.
def fortune(request):
  fortune = random.choice(fortuneList)
  context = {'fortune': fortune}
  return render(request, "randomfortune/fortune.html", context)