# User Guide

## Features 

### Feature 1 
Add `Todo` tasks for tracking purposes.

## Usage

### `todo` - Adds a Todo task

Saves a Todo task into your list of tasks.

Example of usage: 

`todo run`

Expected outcome:

```
Got it. I've added this task:
[T][x] run
Now you have 1 tasks in the list.
```

### Feature 2
Add `Deadline` tasks for tracking purposes.

## Usage

### `deadline` - Adds a Deadline task

Saves a Deadline task into your list of tasks.

Example of usage: 

`deadline assignment /by 20/10/2019 2359`

Expected outcome:

```
Got it. I've added this task:
[D][x] assignment (by: 20 Oct 2019, 11:59:00 PM)
Now you have 2 tasks in the list.
```

### Feature 3
Add `Event` tasks for tracking purposes.

## Usage

### `event` - Adds a Event task

Saves an Event task into your list of tasks.

Example of usage: 

`event meeting /at 20/10/2019 2359`

Expected outcome:

```
Got it. I've added this task:
[E][x] event (at: 20 Oct 2019, 11:59:00 PM)
Now you have 3 tasks in the list.
```

### Feature 4
Lists all tasks for viewing purposes.

## Usage

### `list` - Lists all tasks

Lists all saved tasks.

Example of usage:

`list`

Expected outcome:

```
Here are the tasks in your list:
1. [T][x] run
2. [D][x] assignment (by: 20 Oct 2019, 11:59:00 PM)
3. [E][x] meeting (at: 20 Oct 2019, 11:59:00 PM)
```

### Feature 5
Mark tasks as completed.

## Usage

### `done` - Mark tasks as done

Mark tasks as done

Example of usage:

`done 1`

Expected outcome:

```
Nice! I've marked these task(s) as done:
[T][v] run

These invalid indexes were ignored:
```

Example of usage:

`done 3 4`

Expected outcome:

```
Nice! I've marked these task(s) as done:
[E][v] meeting (at: 20 Oct 2019, 11:59:00 PM)

These invalid indexes were ignored:
4
```

### Feature 6
Find tasks by description.

## Usage

### `find` - Find tasks

Find tasks by its description

Example of usage:

`find`

Expected outcome:

```
Here are the matching tasks in your list:
1. [D][x] assignment (by: 20 Oct 2019, 11:59:00 PM)
```

### Feature 7
Delete tasks

## Usage

### `delete` - Delete tasks

Delete tasks

Example of usage:

`delete 1 3`

Expected outcome:

```
Noted. I've removed these task(s):
1. [E][v] meeting (at: 20 Oct 2019, 11:59:00 PM)
2. [T][v] run

These invalid indexes were ignored:

Now you have 1 tasks in the list.
```

Example of usage:

`delete 1 2`

Expected outcome:

```
Noted. I've removed these task(s):
1. [D][x] assignment (by: 20 Oct 2019, 11:59:00 PM)

These invalid indexes were ignored:
2

Now you have 0 tasks in the list.
```

### Feature 8
Exit application

## Usage

### `bye` - Exit

Prints bye message and exits application

Example of usage:

`bye`

Expected outcome:

```
Bye. Hope to see you soon!
```