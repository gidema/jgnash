/*
 * jGnash, a personal finance application
 * Copyright (C) 2001-2017 Craig Cavanaugh
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jgnash.engine;

import java.util.concurrent.atomic.AtomicLong;

import jgnash.engine.concurrent.Priority;
import jgnash.engine.concurrent.PriorityThreadPoolExecutor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Craig Cavanaugh
 */
public class PriorityThreadTest {

    @Test
    public void testPriorityThreadPoolExecutor() throws Exception {

        final AtomicLong atomicLongSequence = new AtomicLong(0);

        final PriorityThreadPoolExecutor executorService = new PriorityThreadPoolExecutor(1);

        for (int i = 0; i < 25; i++) {
            executorService.submit(() -> {
                final long value = atomicLongSequence.incrementAndGet();

                Thread.sleep(500);
                System.out.println("Background Callable: " + value);
                return null;
            }, Priority.BACKGROUND);
        }

        Thread.sleep(1999);

        executorService.submit(() -> {
            final long value = atomicLongSequence.incrementAndGet();

            Thread.sleep(500);
            System.out.println("System Callable: " + value);

            assertEquals(5, value);
            return null;
        });

        Thread.sleep(5000);

        executorService.shutdown();

        executorService.shutdownNow();
    }
}
