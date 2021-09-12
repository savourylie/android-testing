package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    // If there's no completed task and on active task,
    // then there are 100% percent active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred() {
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, `is`(0f))
        assertEquals(result.activeTasksPercent, `is`(100f))
    }

    // If there's 2 completed tasks and 3 active tasks,
    // then there are 40% percent completed tasks and 60% active tasks

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, `is`(40f))
        assertEquals(result.activeTasksPercent, `is`(60f))
    }

    //If there is one completed task and no active tasks,
    // the activeTasks percentage should be 0f, the completed tasks percentage should be 100f.
    @Test
    fun getActiveAndCompletedStats_noActive_returnsHundredZero() {
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = true)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, `is`(100f))
        assertEquals(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZero() {
        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, `is`(0f) )
        assertEquals(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZero() {
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, `is`(0f))
        assertEquals(result.activeTasksPercent, `is`(0f))
    }
}