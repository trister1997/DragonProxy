package org.dragonet.proxy.utilities;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginDescriptorFinder;

import java.nio.file.Path;

public class PluginManager extends DefaultPluginManager
{

    public PluginManager(Path pluginFolder)
    {
        super(pluginFolder);
    }

    @Override
    protected PluginDescriptorFinder createPluginDescriptorFinder()
    {
        return new YmlPluginDescriptorFinder();
    }

}
