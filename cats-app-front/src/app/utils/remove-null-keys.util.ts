interface AnyObject {
    [key: string]: any;
}

export function removeNullKeys(object: AnyObject): AnyObject {
    return Object.keys(object).reduce(
        (acc, key) =>
            object[key] === null ? acc : Object.assign(acc, {[key]: object[key]}),
        {},
    );
}
