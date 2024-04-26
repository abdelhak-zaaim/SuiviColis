/*
 * **
 *  * @project : SuiviColis
 *  * @created : 26/04/2024, 15:49
 *  * @modified : 26/04/2024, 15:49
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.exceptions;

import java.util.Date;

public record Error (
   String message,
    int statusCode,
    Date timestamp,
    String path
) {
}
