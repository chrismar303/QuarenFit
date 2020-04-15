# **APP OUTLINE**

## LOG FRAGMENT (Combined Body Stats and Exercise into 1 Fragment)
* Calendar
	- weight under day (blank if none)
* When certain day is clicked, summary of entry is display along with a button to view full entry in a different activity
* full entry
	- total calories
	- macros
	- workouts
		* Recycler view
		* clicking a workout will popup full notes description
		* Holding will give option and dialog to delete
	- notes 
* Possible graph view 


## HOME FRAGMENT
* Show Basic stats

### Profile
* height
* weight
* bmi (program calculates)
* goals


### Utility Classes to represent workouts
## Workout
* name, intensity, notes

### Strength Training
* extends Workout
* weight, sets, reps

### Cardio
* extends Workout
* duration