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

import jgnash.util.ResourceUtils;

/**
 * Historical event descriptor for securities.
 *
 * @author Craig Cavanaugh
 */
public enum SecurityHistoryEventType {
    SPLIT(ResourceUtils.getString("SecurityEvent.Split")),
    DIVIDEND(ResourceUtils.getString("SecurityEvent.Dividend"));

    private final transient String description;

    SecurityHistoryEventType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
