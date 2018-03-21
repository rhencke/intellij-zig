package org.ziglang

import org.junit.Assert.assertNotNull
import org.junit.Test
import org.ziglang.project.versionOf
import org.ziglang.project.zigPath
import kotlin.test.assertTrue

class UtilsKtTest {
	@Test(timeout = 1000L)
	fun executeCommand() {
		if (!System.getenv("CI").isNullOrBlank()) return
		executeCommand("zig version", timeLimit = 5000L)
				.also(::println)
				.also(::assertNotNull)
				.also { (stdout, _) -> assertTrue(stdout.isNotEmpty()) }
	}

	@Test
	fun versionOf() {
		if (!System.getenv("CI").isNullOrBlank()) return
		versionOf(zigPath)
	}
}

fun main(args: Array<String>) {
	versionOf("/home/ice1000/SDK/zig").let(::println)
}
