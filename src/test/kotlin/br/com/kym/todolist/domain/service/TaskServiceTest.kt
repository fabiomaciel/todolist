package br.com.kym.todolist.domain.service

import br.com.kym.todolist.domain.model.Task
import br.com.kym.todolist.domain.service.impl.TaskServiceImpl
import br.com.kym.todolist.infra.database.repository.TaskRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.IsCollectionWithSize
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import java.util.*

class TaskServiceTest {

    private val repository: TaskRepository = mockk()
    private val service: TaskService = spyk(TaskServiceImpl(repository))

    @Test
    fun `should return a valid task`() {

        val desired = Task()
        every { repository.findById(any()) } returns Optional.of(desired)

        val retrieved = service.getOne("uuid-test")
        assertThat(retrieved, `is`(Optional.of(desired)))
    }

    @Test
    fun `should return a NotFoundException`() {
        every { repository.findById(any()) } returns Optional.empty()
        val retrieved = service.getOne("uuid-test")
        assertThat(retrieved, `is`(Optional.empty()))

    }

    @Test
    fun `should return a list of elements contained in repository`() {
        every { repository.findAll() } returns listOf(Task())
        val retrieved = service.getAll()
        assertThat(retrieved, IsCollectionWithSize.hasSize(1))
    }

    @Test
    fun `should return a empty list if have nothing on repository`() {
        every { repository.findAll() } returns listOf()
        val retrieved = service.getAll()
        assertThat(retrieved, IsCollectionWithSize.hasSize(0))
    }

}