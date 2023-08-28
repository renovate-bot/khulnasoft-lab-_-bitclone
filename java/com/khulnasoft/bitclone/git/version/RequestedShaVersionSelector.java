/*
 * Copyright (C) 2022 KhulnaSoft Ltd..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.khulnasoft.bitclone.git.version;

import com.khulnasoft.bitclone.git.GitRevision;
import com.khulnasoft.bitclone.util.console.Console;
import com.khulnasoft.bitclone.version.VersionList;
import com.khulnasoft.bitclone.version.VersionSelector;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Given a requested version, if that version is a complete SHA-1, it returns
 * that version as the selected one.
 */
public class RequestedShaVersionSelector implements VersionSelector {

  @Override
  public Optional<String> select(VersionList versionList, @Nullable String requestedRef,
      Console console) {
    if (requestedRef != null && GitRevision.COMPLETE_SHA1_PATTERN.matcher(requestedRef).matches()) {
      return Optional.of(requestedRef);
    }
    return Optional.empty();
  }
}