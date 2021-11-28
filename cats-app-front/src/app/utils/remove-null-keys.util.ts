interface AnyObject {
    [key: string]: any;
}

export function removeEmptyKeys<T extends AnyObject>(object: T): T {
    return Object.keys(object).reduce(
        (acc, key) => (object[key] ? Object.assign(acc, {[key]: object[key]}) : acc),
        {},
    ) as T;
}
