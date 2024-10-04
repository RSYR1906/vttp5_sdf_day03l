# Lecture 3 notes

.flush() is used to save whatever is written in the new file

Must remember to close the readers and the stream after using, to prevent memory leak.

**FileWriter fw = new FileWriter(file, true);**
If append = true, it means to add on to the current file
If append = false, it will overwrite the current file

## Commands

javac --source-path . LectureExamples/App.java
java LectureExamples.App "data" "myfile.txt"
