/*
 * Copyright (C) 2014 Codelanx, All Rights Reserved
 *
 * This work is licensed under a Creative Commons
 * Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 *
 * This program is protected software: You are free to distrubute your
 * own use of this software under the terms of the Creative Commons BY-NC-ND
 * license as published by Creative Commons in the year 2014 or as published
 * by a later date. You may not provide the source files or provide a means
 * of running the software outside of those licensed to use it.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the Creative Commons BY-NC-ND license
 * long with this program. If not, see <https://creativecommons.org/licenses/>.
 */
package com.codelanx.portal;

import com.codelanx.codelanxlib.config.ConfigurationLoader;
import com.codelanx.codelanxlib.implementers.Configurable;
import com.codelanx.codelanxlib.implementers.Listening;
import com.codelanx.codelanxlib.listener.ListenerManager;
import com.codelanx.portal.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Class description for {@link Portal}
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public final class Portal extends JavaPlugin implements Listening<Portal>, Configurable {

    private ListenerManager<Portal> listener;
    private ConfigurationLoader config;

    @Override
    public void onEnable() {
        this.config = new ConfigurationLoader(this, ConfigValue.class);

        this.listener = new ListenerManager<>(this);
        this.listener.registerListeners(new GunListener(this));
    }

    @Override
    public ListenerManager<Portal> getListenerManager() {
        return this.listener;
    }

    @Override
    public ConfigurationLoader getConfiguration() {
        return this.config;
    }

}
