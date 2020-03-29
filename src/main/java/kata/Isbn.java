/*
 * Copyright (C) Fortumo OÜ, 2020
 * All rights reserved. Proprietary and confidential.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *
 * All rights reserved. Proprietary and confidential.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Distribution, modification, reproduction, merging, publishing, sub-licensing,
 * sale and/or any other use (in binary form or otherwise) of this software is
 * not permitted, unless Fortumo OÜ has explicitly and in writing permitted such
 * use of the software.
 *
 * THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Fortumo OÜ BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package kata;

public abstract class Isbn {

    private static final int ISBN_10_LENGTH = 10;
    private static final int ISBN_13_LENGTH = 13;

    private final String value;

    public static Isbn from(final String input) {
        final String sanitizedInput = sanitize(input);
        validateNumericInput(sanitizedInput);

        if (ISBN_13_LENGTH == sanitizedInput.length()) {
            return new Isbn13(sanitizedInput);
        } else if (ISBN_10_LENGTH == sanitizedInput.length()) {
            return new Isbn10(sanitizedInput);
        } else {
            throw new IllegalArgumentException("expected input with 10 or 13 chars");
        }
    }

    Isbn(String value) {
        this.validateChecksum(value);
        this.value = value;
    }

    private static String sanitize(String input) {
        return input.replace("-", "")
                    .replace(" ", "");
    }

    private static void validateNumericInput(String isbn) {
        try {
            Long.parseLong(isbn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("expected input to only contain digits");
        }
    }

    abstract void validateChecksum(String isbn);

    public String getValue() {
        return this.value;
    }
}
