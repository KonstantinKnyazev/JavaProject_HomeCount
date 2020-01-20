/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author Konstantin Knyazev
 */
class CachedCompositeIcon {

//    public CachedCompositeIcon(ImageIcon icon, ImageIcon ICON_ABOUT) {
//    }
    
    private static final byte ICON_PADDING = 2;
    private static final HashMap<CachedCompositeIcon, ImageIcon> CACHED_ICONS =
            new HashMap<CachedCompositeIcon, ImageIcon>( 4 );

    private final ImageIcon[] m_icons;

    public CachedCompositeIcon(final ImageIcon... icons) {
        m_icons = icons;
    }

    public ImageIcon getIcon() {
        if ( !CACHED_ICONS.containsKey( this ) ) {
            CACHED_ICONS.put( this, lcl_combineIcons() );
        }

        return CACHED_ICONS.get( this );
    }

    /** Generates an icon that is a composition of several icons by appending each icon together with some
     *  padding between them.
     *
     * @return An icon that is the concatenation of all the icons this was constructed with.
     */
    private ImageIcon lcl_combineIcons() {
        // First determine how big our composite icon will be; we need to know how wide & tall to make it.
        int totalWidth = (m_icons.length - 1) * ICON_PADDING; // Take into account the padding between icons
        int minHeight  = 0;
        for ( int i = 0; i < m_icons.length; ++i ) {
            totalWidth += m_icons[i].getIconWidth();
            if ( m_icons[i].getIconHeight() > minHeight ) {
                minHeight = m_icons[i].getIconHeight();
            }
        }

        // Create an image big enough and acquire the image canvas to draw on
        final BufferedImage compositeImage = new BufferedImage( totalWidth, minHeight, BufferedImage.TYPE_INT_ARGB );
        final Graphics      graphics       = compositeImage.createGraphics();

        // Iterate over the icons, painting each icon and adding some padding space between them
        int x = 0;
        for ( int i = 0; i < m_icons.length; ++i ) {
            final ImageIcon icon = m_icons[ i ];
            graphics.drawImage( icon.getImage(), x, 0, null );
            x += icon.getIconWidth() + ICON_PADDING;
        }

        return new ImageIcon( compositeImage );
    }

    /** Generates a hash that takes into account the number of icons this composition includes and the hash &
     *  order of those icons.
     *
     * @return A hash code.
     */
    @Override
    public int hashCode() {
        int weakHash = m_icons.length;
        for ( int i = 0; i < m_icons.length; ++i ) {
            weakHash += m_icons[i].hashCode() * (i + 1);
        }
        return weakHash;
    }

    /** Two instances are equal if and only if they include the same icons and they're in the same order.
     *
     * @param obj An object to check for equality with this.
     *
     * @return true if the two objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if ( !(obj instanceof CachedCompositeIcon) ) {
            return false;
        }

        final CachedCompositeIcon other = (CachedCompositeIcon) obj;
        if ( m_icons.length != other.m_icons.length ) {
            return false;
        }

        for ( int i = 0; i < m_icons.length; ++i ) {
            if ( m_icons[i].hashCode() != other.m_icons[i].hashCode() ) {
                return false;
            }
        }

        return true;
    }
    
}
